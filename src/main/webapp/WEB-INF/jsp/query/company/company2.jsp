<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ taglib prefix="x" uri="/xdq/exl" %>
	
	<x:table xlsName="my" printLandscape="true" >
		
  		<x:div border="1">
	    	<x:tr >
	      	<x:td width="100">序号</x:td><x:td width="100">订单号</x:td><x:td>规格</x:td><x:td>投胚量</x:td><x:td>成品量</x:td><x:td>一等品</x:td>
	      	<x:td>二等品</x:td><x:td>三等品</x:td><x:td>等外品</x:td><x:td>合格率</x:td>
	      	</x:tr> 
	
	  		 <c:forEach items="${companys}" var="company"  varStatus="vs">
	  			<x:tr>
	  			<x:td align="center">${vs.count}</x:td>
	  			<x:td align="center">${company.plan_id}</x:td>
	  			<x:td align="center">${company.standard_name}</x:td>
	  			<x:td align="center">${company.num_group}</x:td>
	  			<x:td align="center">${company.num_check}</x:td>
	  			<x:td align="center">${company.yd_product}</x:td>
	  			<x:td align="center">${company.ed_product}</x:td>
	  			<x:td align="center">${company.sd_product}</x:td>
	  			<x:td align="center">${company.dw_product}</x:td>
	  			<x:td align="center">${company.qulifed_rate}</x:td>
	  			</x:tr>
	  		</c:forEach> 
	  		<x:tr>
	  			<x:td colspan="3" align="center">合计</x:td>
  				<x:td align="center">${companyLast.num_group}</x:td>
  				<x:td align="center">${companyLast.num_check}</x:td>
  				<x:td align="center">${companyLast.yd_product}</x:td>
  				<x:td align="center">${companyLast.ed_product}</x:td>
  				<x:td align="center">${companyLast.sd_product}</x:td>
  				<x:td align="center">${companyLast.dw_product}</x:td>
  				<x:td align="center">${companyLast.qulifed_rate}</x:td>
	  		</x:tr>
  		</x:div>
	</x:table>

</body>
</html>