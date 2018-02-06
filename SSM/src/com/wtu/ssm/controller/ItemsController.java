package com.wtu.ssm.controller;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.entity.QueryVo;
import com.wtu.ssm.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping("/items")
public class ItemsController {

    @Resource
    private ItemsService itemsService;

    @RequestMapping(value = "/findItemsByName.do", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView findItemsByName(QueryVo queryVo) {
        List<Items> itemsList = itemsService.findItemsByName(queryVo);

        ModelAndView mv = new ModelAndView();

        mv.addObject("itemsList", itemsList);
        mv.setViewName("/itemsList");
        return mv;
    }

    /*
    @RequestMapping(value = "/findItemsById.do")
    public ModelAndView findItemsById(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        Items items = itemsService.findItemsById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("item", items);
        modelAndView.setViewName("/editItem");

        return modelAndView;
    }
    */

    @RequestMapping(value = "/findItemsById.do")
    public String findItemsById(HttpServletRequest request, Model model, @RequestParam(value = "id2",
            required = true, defaultValue = "1") Integer id) throws Exception {
//        Integer id = Integer.parseInt(request.getParameter("id"));
        Items items = itemsService.findItemsById(id);
        // 将数据存储到模型, 相当于modelAndView.addObject(name, value);
        model.addAttribute("items1", items);

//        return "/editItem";
        // 转发和重定向
//        return "redirect:" + "/jsp/editItem.jsp";
        return "forward:/jsp/editItem.jsp";
    }

    // 修改信息
    @RequestMapping(value = "/updateItems.do")
    public String updateItems(Model model,
                              @Validated @ModelAttribute("items1") Items items, BindingResult bindingResult,
                              @RequestParam("pictureFile") MultipartFile pic) throws Exception {
//        model.addAttribute("items1", items);
        /*
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        Double price = Double.parseDouble(request.getParameter("price"));
        // 封装一个Items对象
        Items items = new Items();
        items.setId(id);
        items.setDetail(detail);
        items.setPrice(price);
        items.setName(name);
        */
        /*
        QueryVo queryVo = new QueryVo();
        queryVo.setItems(items);
        */



        if (bindingResult.hasErrors()) {
            // 获取错误的信息
            List<ObjectError> errorList = bindingResult.getAllErrors();
            // 将错误信息保存到request域中
//            errorList.get(0).getDefaultMessage();
            model.addAttribute("errorList", errorList);
            // 转发到商品修改页面
            return "forward:/jsp/editItem.jsp";
        }

        // 下面是图片上传的代码
        if (!pic.isEmpty()) {
            // 得到图片的原始文件名
            String originalName = pic.getOriginalFilename();
            // 指定带盘符的路径, 物理路径
            String realPath = "E:\\temp\\";
            /*
                为了处理出现重名现象, 将原始文件名去掉,
                通过UUID算法生成新的文件名
             */
            String uuidName = UUID.randomUUID().toString();
            // uuid名称加上文件的后缀名

            String newFile = uuidName + originalName.substring(originalName.lastIndexOf("."));
            // 创建File文件
            File file = new File(realPath + newFile);
            // 将图片写入到具体的位置
            pic.transferTo(file);
            // 将文件名保存到数据库
            items.setPic(newFile);


        }



        itemsService.updateItems(items);
        return "redirect:/findItemsByName.do";

        // 重定向 /findItemsByName.do
//        response.sendRedirect(request.getContextPath() + "/findItemsByName.do");
    }

    // 批量删除多个商品
    @RequestMapping(value = "/deleteItemsByIds.do")
    public String deleteItemsByIds(Integer[] ids) {

        return "redirect:/jsp/success.jsp";
    }

    // 批量修改
    @RequestMapping(value = "/findItems.do", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView findItems(QueryVo queryVo) {
        List<Items> itemsList = itemsService.findItemsByName(queryVo);

        ModelAndView mv = new ModelAndView();

        mv.addObject("itemsList", itemsList);
        mv.setViewName("/editItemsAll");
        return mv;
    }

    /**
     * 批量修改以后的提交
     * 如果参数是集合类型, 那不能再形式参数中直接定义List类型
     * 而只能采用自定义的包装类型QueryVo
     * 然后再在QueryVo中封装一个List集合
     * @param queryVo
     * @return
     */
    @RequestMapping("/editItemsAllSubmit.do")
    public String editItemsAllSubmit(QueryVo queryVo) {

        return "redirect:/jsp/success.jsp";
    }
}





















