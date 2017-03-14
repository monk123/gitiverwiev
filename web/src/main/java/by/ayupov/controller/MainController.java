package by.ayupov.controller;

import by.ayupov.entity.Product;
import by.ayupov.entity.User;
import by.ayupov.services.interfaces.ProductService;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@Log
public class MainController {

    @Autowired
    private ProductService productsService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        fillProduct(model);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String submit(ModelMap model) {
        model.addAttribute("userForm", new User());

        return "/login";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        model.addAttribute("categories", this.productsService.findProductByCategory());
        fillProduct(model);
        model.addAttribute("user", getPrincipal());
        return "redirect:/table";
    }

    @RequestMapping("product/{pageNumber}")
    public String listProdId(@PathVariable("pageNumber") Integer pages, Model model) {
        Page<Product> page = productsService.findAllByPage(pages);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        return "product";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/bucket/product/{id}", method = RequestMethod.GET)
    public String getBucket(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productsService.getEntityById(id));
        return "bucket";
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public String getBucket(Model model) {
        return "bucket";
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String getTable(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", productsService.getAll());
        return "table";
    }

    @RequestMapping(value = "/table/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        this.productsService.add(product);
        return "redirect:/table";
    }

    @RequestMapping(value = "/table/avatar/add", method = RequestMethod.POST)
    public String addProduct(Model map,
                             @RequestParam(value="avatar", required=false) MultipartFile image) {
        try {
            if (image != null && !image.isEmpty()) {
                validateImage(image);
                saveImage(".jpg", image);
            }
        } catch (IOException e) {
            //Error handling
        } finally {
            fillProduct(map);
        }

        return "redirect:/table";
    }

    @RequestMapping("/remove/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        this.productsService.delete(id);
        return "redirect:/table";
    }

    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", this.productsService.getEntityById(id));
        model.addAttribute("listProduct", this.productsService.getAll());

        return "table";
    }

    @RequestMapping("data/{id}")
    public String dataProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", this.productsService.getEntityById(id));
        return "data";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getContact() {
        return "contact";
    }

    private void fillProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", productsService.paginationProduct(0, 4));
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private void validateImage(MultipartFile image) throws IOException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new IOException("Only JPG images accepted");
        }
    }
    private void saveImage(String filename, MultipartFile image) throws IOException {
        File file = new File("/resources/img/" + filename);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
    }
}

