package th.co.acc.dwi.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.acc.dwi.model.OrderList;
import th.co.acc.dwi.model.WorkOrder;

@FeignClient(name = "order-service", url = "${DWI_WS_URL:http://localhost:8100/dwi-ws}")
//@FeignClient(name = "dwi-ws")
public interface WorkOrderService {
	
	@RequestMapping(method = RequestMethod.POST, value ="/listOrders" )
	public List<WorkOrder> getOrderListForScreen(OrderList orderlist) throws Exception;
}
