package neu.xindong.xact.controller;

import neu.xindong.xact.dto.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sysUser")
public class SysUserController {
    @GetMapping("/test")
    public HttpResponse<String> a(){
        return HttpResponse.success("okkkk");
    }
}