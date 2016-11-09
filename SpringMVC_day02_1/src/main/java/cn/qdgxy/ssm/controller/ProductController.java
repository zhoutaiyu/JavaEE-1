package cn.qdgxy.ssm.controller;

import cn.qdgxy.ssm.controller.validation.ValidGroup1;
import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.po.ProductQueryVo;
import cn.qdgxy.ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * 商品控制器
 * create:2016-10-30 20:51
 * <p>
 * author 李欣
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/product") //定义url的根路径，访问时根路径+方法的url
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 单独将商品类型的方法提出来，将方法返回值填充到request，在页面显示
     *
     * @return
     * @throws Exception
     */
    @ModelAttribute("productType.action")
    public Map<String, String> getProductType() throws Exception {
        Map<String, String> productType = new HashMap<>();
        productType.put("001", "数码");
        productType.put("002", "服装");
        productType.put("003", "家电");
        return productType;
    }

    /**
     * 查找所有商品
     *
     * @return ModelAndView
     * @throws Exception 异常
     */
    @RequestMapping("findAllProduct.action")
    public ModelAndView findAllProduct() throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        // 指定逻辑视图名
        modelAndView.setViewName("productList");

        return modelAndView;
    }

    //方法返回 字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
    @RequestMapping(value = "/editProduct.action")
    public String editProduct(Model model, Integer id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 数据回显，将id传到页面
        model.addAttribute("id", id);

        // 调用service查询商品信息
        ProductCustom productCustom = productService.findProductById(id);

        //  将模型数据传递到jsp
        model.addAttribute("product", productCustom);

        return "editProduct";
    }

    /**
     * 修改单个商品提交
     *
     * @param model
     * @param id
     * @param productCustom
     * @return
     * @throws Exception
     */
    @RequestMapping("/editProductSubmit.action")
    public String editProductSubmit(Model model,
                                    Integer id,
                                    @Validated(value = {ValidGroup1.class}) @ModelAttribute("product") ProductCustom productCustom,
                                    BindingResult bindingResult,
                                    // 上传图片
                                    MultipartFile pictureFile) throws Exception {

        //输出校验错误信息
        //如果参数绑定时有错
        if (bindingResult.hasErrors()) {
            //获取错误
            List<ObjectError> errors = bindingResult.getAllErrors();
            //准备在页面输出errors，页面使用jstl遍历
            model.addAttribute("errors", errors);
            for (ObjectError error : errors) {
                //输出错误信息
                System.out.println(error.getDefaultMessage());
            }
            //如果校验错误，回到商品修改页面
            return "editProduct";
        }


        //进行图片上传
        if (pictureFile != null && pictureFile.getOriginalFilename() != null
                && pictureFile.getOriginalFilename().length() > 0) {
            //图片上传成功后，将图片的地址写到数据库
            String filePath = "F:\\upload\\image\\";
            //上传文件原始名称
            String originalFilename = pictureFile.getOriginalFilename();
            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件
            File file = new java.io.File(filePath + newFileName);

            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);

            //图片上传成功，将新图片地址写入数据库
            productCustom.setPic(newFileName);
        }

        //调用service接口更新商品信息
        productService.updateProduct(id, productCustom);

        // 提交后回到修改页面
        return "editProduct";

        //请求重定向
        //return "redirect:findAllProduct";
        //转发
        //return "forward:findAllProduct";
    }

    /**
     * 删除商品
     *
     * @param delete_id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteProduct.action")
    public String deleteProduct(Integer[] delete_id) throws Exception {

        System.out.println(Arrays.toString(delete_id));

        // 调用service删除
        // .....

        return "success";
    }

    /**
     * 批量修改商品查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/editProductList.action")
    public ModelAndView editItemsList() throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        // 指定逻辑视图名
        modelAndView.setViewName("editProductList");

        return modelAndView;
    }

    /**
     * 批量修改商品提交
     *
     * @param productQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping("/editItemsListSubmit.action")
    public String editItemsListSubmit(ProductQueryVo productQueryVo) throws Exception {

        return "success";
    }


}
