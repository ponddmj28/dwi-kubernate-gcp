package th.co.acc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import th.co.acc.dwi.model.OrderList;
import th.co.acc.dwi.model.OrderPackage;
import th.co.acc.dwi.model.StatusOrder;
import th.co.acc.dwi.model.SubmitOrderScreen;
import th.co.acc.dwi.model.UpdatedOrderScreen;
import th.co.acc.dwi.model.WorkOrder;
import th.co.acc.dwi.service.OrderService;

@RestController
public class OrderJobController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/isAlive" ,method=RequestMethod.GET)
	public String isAlive() {
		return "{healthy:true}";
	}
	
	@RequestMapping(value = "/getAllpackages",method=RequestMethod.POST)
	public List<OrderPackage> getAllPackages() throws Exception {
		return orderService.getAllPackages();
	}
	
	@RequestMapping(value = "/submitOrder",method=RequestMethod.POST)
	public SubmitOrderScreen  submitOrderScreen( HttpServletRequest request,@RequestBody SubmitOrderScreen submitOrderScreen) throws Exception {
		return orderService.applyOrder(submitOrderScreen);
	}
	
	@RequestMapping(value = "/submitOrder/uploadImg/{filename}",method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void  uploadingImg(HttpServletRequest request,@PathVariable("filename") String filename) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		multipartRequest.getFileMap().entrySet().forEach(entry-> {
			try {
				orderService.uploadingImg(entry.getValue(),filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}
	
	@RequestMapping(value = "/orderDetail/{jobId}",method=RequestMethod.POST)
	public SubmitOrderScreen orderDetailScreen(@PathVariable("jobId") String jobId) throws Exception {
		return orderService.getOrderJobByJobId(jobId);
	}
	
	@RequestMapping(value = "/listOrders",method=RequestMethod.POST)
	public List<WorkOrder> getOrderListForScreen(
			@RequestBody OrderList orderlist
			) throws Exception {
		return orderService.getOrderListForScreen(orderlist);
	}
	
	@RequestMapping(value = "/getAllstatus",method=RequestMethod.POST)
	public List<StatusOrder> getAllStatus() throws Exception {
		return orderService.getAllStatus();
	}
	
	@RequestMapping(value = "/updateOrderByJobId",method=RequestMethod.POST)
	public void rejectOrClosed(
			@RequestBody UpdatedOrderScreen updatedOrderScreen) throws Exception {
		orderService.updateOrderByJobId(updatedOrderScreen);
	}
}
