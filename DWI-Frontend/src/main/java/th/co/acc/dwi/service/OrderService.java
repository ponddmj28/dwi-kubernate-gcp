package th.co.acc.dwi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import th.co.acc.dwi.model.OrderList;
import th.co.acc.dwi.model.OrderPackage;
import th.co.acc.dwi.model.StatusOrder;
import th.co.acc.dwi.model.SubmitOrderScreen;
import th.co.acc.dwi.model.UpdatedOrderScreen;
import th.co.acc.dwi.model.UserInfo;
import th.co.acc.dwi.model.WorkOrder;

@FeignClient(name = "order-service", url = "${DWI_WS_URL:http://localhost:8100/dwi-ws}")
public interface OrderService  {
	
	@RequestMapping(method = RequestMethod.POST, value ="/submitOrder" )
	public SubmitOrderScreen applyOrder(SubmitOrderScreen submitOrderScreen) throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/submitOrder/uploadImg/{filename}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void uploadingImg(MultipartFile file,@PathVariable(value = "filename") String id) throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/orderDetail/{jobId}") 
	public SubmitOrderScreen getOrderJobByJobId(@PathVariable(value = "jobId") String jobId) throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/listOrders" )
	public List<WorkOrder> getOrderListForScreen(OrderList orderlist) throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/getAllpackages")
	public List<OrderPackage> getAllPackages() throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/getAllstatus")
	public List<StatusOrder> getAllStatus() throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/getUserInfoInListOrder")
	public List<UserInfo> getUserInfoInListOrder() throws Exception;
	
	@RequestMapping(method = RequestMethod.POST, value ="/updateOrderByJobId")
	public void updateOrderByJobId(UpdatedOrderScreen updatedOrderScreen) throws Exception;
	
}
