package com.phicomm.netrouter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phicomm.netrouter.handler.NetRouterServerHandler;
import com.phicomm.netrouter.manager.IDeviceManager;
import com.phicomm.netrouter.model.IotDevice;
import com.phicomm.netrouter.server.NetRouterServer;
import com.phicomm.netrouter.service.NRService;

@Controller
public class RooterController {
	@Autowired
	private NRService iotDeviceService;
	@Autowired
	private IDeviceManager deviceManager;
	@Autowired
	private NetRouterServerHandler handler;
//	@Autowired
//	private NetRouterServer server;

	@RequestMapping("/showInfo/{deviceid}")
	public @ResponseBody Object showNrDeviceInfo(ModelMap modelMap, @PathVariable int deviceid) {
		IotDevice userInfo = iotDeviceService.getDeviceByPrimaryKey(deviceid);
		modelMap.addAttribute("userInfo", userInfo);
		deviceManager.test();
		handler.test();
//		server.start();
		return modelMap;
	}
}
