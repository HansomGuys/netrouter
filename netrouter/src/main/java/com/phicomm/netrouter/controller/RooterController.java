package com.phicomm.netrouter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phicomm.netrouter.model.NrDevice;
import com.phicomm.netrouter.service.NrDeviceService;

@Controller  
public class RooterController {
	@Autowired  
    private NrDeviceService nrDeviceService;  
      
    @RequestMapping("/showInfo/{deviceid}")  
    public @ResponseBody Object showNrDeviceInfo(ModelMap modelMap, @PathVariable int deviceid){  
        NrDevice userInfo = nrDeviceService.getDeviceByPrimaryKey(deviceid);  
        modelMap.addAttribute("userInfo", userInfo);  
        return modelMap;  
    }  
}