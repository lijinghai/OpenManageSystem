package priv.ljh.utils.fastDFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class FastDfsService {
    private static final Logger log =
            LoggerFactory.getLogger(FastDfsService.class);
    private static String serverFdfs;

    @Value("${fastdfs.racker_server}")
    public void setServerFdfs(String serverFdfs) {
        FastDfsService.serverFdfs = serverFdfs;
    }

    public static Map<String, String> uploadFile(MultipartFile
                                                         multipartFile, String author) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            FastDFSFile file = new FastDFSFile();
            file.setAuthor(author);
            String ext =
                    multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename
                            ().lastIndexOf(".") + 1);
            file.setContent(multipartFile.getBytes());
            file.setName(multipartFile.getOriginalFilename());
            file.setExt(ext);
            String filePath[] = FastDfsUtil.upload(file);
            result.put("fileUrl", serverFdfs + filePath[0] + "/" +
                    filePath[1]);
            result.put("fileUrl_down", filePath[0] + "/" + filePath[1]);
            log.info(serverFdfs + filePath[0] + "/" + filePath[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void downloadFile(String fileUrl, HttpServletResponse
            response, HttpServletRequest request) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        String ext = path.substring(path.lastIndexOf("."));
        byte[] data = FastDfsUtil.downFile(group, path);
        BufferedInputStream bis = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            os = response.getOutputStream();
            bos = new BufferedOutputStream(os);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            // 不同类型的⽂件对应不同的MIME类型
            response.setContentType("application/x-msdownload");
            // inline在浏览器中直接显示，不提示⽤户下载,attachment弹出对话框，提示⽤户进⾏下载保存本地,默认为inline⽅式
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    setFileDownloadHeader(request, UUID.randomUUID() + ext));
            // 将⽂件发送到客户端
            bos.write(data, 0, data.length);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        } finally {
            // 特别重要 1. 进⾏关闭是为了释放资源 2. 进⾏关闭会⾃动执⾏flush⽅法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    /**
     * 下载⽂件名重新编码
     *
     * @param request  请求对象
     * @param fileName ⽂件名
     * @return 编码后的⽂件名
     */
    public static String setFileDownloadHeader(HttpServletRequest request,
                                               String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // ⽕狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}