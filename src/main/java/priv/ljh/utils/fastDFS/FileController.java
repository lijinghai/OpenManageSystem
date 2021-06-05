//package priv.ljh.utils.fastDFS;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
///**
//* ⽂件操作处理
// * @author lijinghai
// * @Date 2021-6-5
// * */
//
//
//@RestController
//@Api(tags = {"⽂件操作处理"})
//public class FileController
//{
// @Resource
// private HttpServletResponse response;
// @Resource
// private HttpServletRequest request;
// @PostMapping("/fastdfsUpload")
// @ApiOperation("fastdfs上传⽂件")
// public Result fastdfsUpload(MultipartFile file) throws IOException
// {
// Map<String,String> info = FastDfsService.uploadFile(file,"xywang");
// return null==info.get("fileUrl")?new Result(500,"上传失败",null):new
//Result(200,"上传成功",info);
// }
// @GetMapping("/fastdfsDownload")
// @ApiOperation("fastdfs下载⽂件")
// public void fastdfsDownload(@RequestParam("url") String url) throws
//IOException
// {
// FastDfsService.downloadFile(url,response,request);
// }
//}
