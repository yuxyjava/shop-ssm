<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
<link type="text/css" rel="styleSheet" href="<%=request.getContextPath()%>/js/easyui/themes/black/easyui.css">
<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=request.getContextPath() %>/js/uploadify/uploadify.css" rel="stylesheet" ></link>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/my97/WdatePicker.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="<%=request.getContextPath() %>/js/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="<%=request.getContextPath() %>/js/kindeditor/lang/zh_CN.js"></script>
<title>员工管理</title>

<script type="text/javascript">
$(function(){
	
	
	$('#productListGrid').datagrid({
		title : '产品列表',
		url : '<%=request.getContextPath()%>/productEasyUi/findProductList.jhtml',
		//指明哪一个字段是标识字段
		//idField : 'id',
		columns:[ [ {
			//列字段名称。
			field : 'productName',
			title : '产品名',
			width : 300,
			align : 'center'
		}, {
			//列字段名称。
			field : 'productMainImageUrl',
			title : '产品主图',
			width : 300,
			align : 'center',
			formatter:function(value,row,index){
				return "<img src='"+value+"' width='50px' height='50px'/>"
			}
		},{
			//列字段名称。
			field : 'brand',
			title : '品牌名',
			width : 300,
			align : 'center',
			formatter:function(value,row,index){
				return row.brand.brandName;
			}
		},{
			field : 'price',
			title : '产品价格',
			width : 200,
			align : 'center'
		}, {
			field : "enterDate",
			title : "入库时间",
			width : 400,
			align : "center"
		}, {
			field : "id",
			title : "操作",
			width : 400,
			align : "center",
			formatter : function(val) {
                return "<a href='javascript:remove("+val+");'>删除</a>";
			}
		} ] ],
		//如果为true，则在DataGrid控件底部显示分页工具栏
		pagination: true,
		//如果为true，则显示一个行号列
		rownumbers : true,
		//如果为true则只允许选择一行,默认false。
		singleSelect : true
	    
	});
	
	
	var p = $('#productListGrid').datagrid('getPager'); 
	$(p).pagination({ 
	    pageSize: 5,//每页显示的记录条数，默认为10 
	    pageList: [5,10,15],//可以设置每页记录条数的列表 
	    beforePageText: '第',//页数文本框前显示的汉字 
	    afterPageText: '页    共 {pages} 页', 
	    displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    onBeforeRefresh:function(){
	    	//提示正在加载
	        $(this).pagination('loading');
	    	//刷新分页组件
	         $(this).pagination('loaded');
	    }
	});
	
	var editor;
	var update_editor;
	
	$("#updateProductDialog").dialog( {
		width : "850",
		height : "520",
		cache: false,    
		modal: true,
		onLoad: function (event, ui) {// 当Dialog中的页面加载完毕后创建编辑器
			update_editor = KindEditor.create('textarea[id="updateproductDesc"]', {
			resizeType : 0,
			uploadJson : '<%=request.getContextPath() %>/jsp/upload_json.jsp',
			fileManagerJson : '<%=request.getContextPath() %>/jsp/file_manager_json.jsp',
			 allowFileManager: true
			});
			},
			onBeforeClose: function (event, ui) {
			// 关闭Dialog前移除编辑器
			  // KindEditor.remove('textarea[id="productDesc"]');
			},

		//对话框窗口底部按钮，可用值有：1) 一个数组，每一个按钮的属性都和linkbutton相同。2) 一个选择器指定按钮栏。
		buttons : [ {
			text : "更新",
			//显示背景图片的CSS类ID
			iconCls : "icon-save",
			//当按钮被点击时调用的一个函数。
			handler : function() {
				update_editor.sync();// 只有在进行ajax提交kindeditor中内容时才需要
				//使普通表单成为ajax提交方式的表单。
				$("#updateProductForm").form("submit", {
					url : "<%=request.getContextPath()%>/productEasyUi/updateProduct.jhtml",
					success : function(result) {
						var v_info = eval("("+result+")");
						if (v_info.success) {
							//重新加载数据表格
						    $("#productListGrid").datagrid("reload");
							//关闭对话框
							$("#updateProductDialog").dialog("close");
						}
					}
				});
			}
		}, {
			text : "取消",
			iconCls : "icon-cancel",
			handler : function() {
				$("#updateProductDialog").dialog("close");
			}
		} ]
	});
	//构造对话框
	$("#productDialog").dialog( {
		width : "850",
		height : "520",
		cache: false,    
		href:"<%=request.getContextPath()%>/productEasyUi/toAddProduct.jhtml",
		modal: true,
		onLoad: function (event, ui) {// 当Dialog中的页面加载完毕后创建编辑器
			editor = KindEditor.create('textarea[id="productDesc"]', {
			resizeType : 0,
			uploadJson : '<%=request.getContextPath() %>/jsp/upload_json.jsp',
			fileManagerJson : '<%=request.getContextPath() %>/jsp/file_manager_json.jsp',
			 allowFileManager: true
			});
			},
			onBeforeClose: function (event, ui) {
			// 关闭Dialog前移除编辑器
			   //KindEditor.remove('textarea[id="productDesc"]');
			},

		//对话框窗口底部按钮，可用值有：1) 一个数组，每一个按钮的属性都和linkbutton相同。2) 一个选择器指定按钮栏。
		buttons : [ {
			text : "保存",
			//显示背景图片的CSS类ID
			iconCls : "icon-save",
			//当按钮被点击时调用的一个函数。
			handler : function() {
				editor.sync();// 只有在进行ajax提交kindeditor中内容时才需要
				//使普通表单成为ajax提交方式的表单。
				$("#productForm").form("submit", {
					url : "<%=request.getContextPath()%>/productEasyUi/addProduct.jhtml",
					success : function(result) {
						var v_info = eval("("+result+")");
						if (v_info.success) {
							//重新加载数据表格
						    $("#productListGrid").datagrid("reload");
							//关闭对话框
							$("#productDialog").dialog("close");
						}
					}
				});
			}
		}, {
			text : "取消",
			iconCls : "icon-cancel",
			handler : function() {
				$("#productDialog").dialog("close");
			}
		} ]
	});
	
});



</script>
<script type="text/javascript">

function addProduct() {
	//打开对话框并且设置为添加用户
	 $("#productDialog").dialog("open").dialog("setTitle", "添加产品");
}

function reset() {
	$("#productSearchForm").form('reset');
}

function searchProduct() {
	var v_productName = $.trim($("#productName").val());
	var v_brandId = $("#brandId").combobox('getValue');
	//使用参数查询
    $("#productListGrid").datagrid("load",{"productName":v_productName,"brand.id":v_brandId});
}

function editProduct() {
	//getSelections返回所有被选中的行，当没有记录被选中的时候将返回一个空数组。
    var selectedRows = $("#productListGrid").datagrid("getSelections");
	   if(selectedRows.length <= 0){
			$.messager.alert("提示", "请选择需编辑的行", "error");
	   } else{
		   var v_id = selectedRows[0].id;
		   $("#updateProductDialog").dialog("refresh", "<%=request.getContextPath()%>/productEasyUi/toUpdateProduct.jhtml?id="+v_id)
		   							.dialog("open")
		   							.dialog("setTitle", "更新产品");
	  }	     
}


</script>

</head>
<body > 
 <div class="easyui-panel" style="padding:1px;width:100%;" title="查询条件" >
 <form id="productSearchForm">
		         <table>
		         	  <tr>
		         	    <td>产品名:</td>
			    	  	<td><input  id="productName" class="easyui-textbox" data-options="iconCls:'icon-man',iconAlign:'left'       
			    	  	"/></td>
			    	    <td>产品价格:</td>
			    	  	<td><input  id="minPrice" class="easyui-numberspinner" data-options="min:0"/>-<input  id="maxPrice" class="easyui-numberspinner" class="easyui-numberspinner" data-options="min:0"/></td>
			    	  	<td>入库日期:</td>
			    	  	<td><input type="text" id="minDate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'maxDate\')}'})" class="Wdate"/>-<input type="text" id="maxDate" class="Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'minDate\')}',maxDate:'2020-10-01'})"/></td>
			    	  	<td>品牌列表:</td>
			    	  	<td>
			    	  		<select id="brandId" class="easyui-combobox">
			    	  			<option value="-1">===请选择===</option>
			    	  			<c:forEach	items="${brandList }" var="brand">
			    	  			<option value="${brand.id }">${brand.brandName }</option>
			    	  			</c:forEach>
			    	  		</select>
			    	  	</td>
		         	  </tr>
		         	  <tr>
			    	  	<td><a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" plain="true" id="btnQuery" onclick="searchProduct();">查询</a></td>
			       	 	<td><a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" plain="true" id="btnReset" onclick="reset();">重置</a></td>
		         	  </tr>
		         </table>                   
			  	</form>
 </div>

<div>
<table id="productListGrid" toolbar="#productListToolbar"></table>
</div>

<div id="productListToolbar" style="height:auto">
	 	    	<div> 
		          <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="btnSave" onclick="addProduct();">添加</a>
		          <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="btnEdit" onclick="editProduct();">编辑</a>
	    	      <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="btnDelete">删除</a>
	    		  <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" plain="true" id="btnReload">刷新</a>
	    		</div>
    		
</div>
 <!--添加产品对话框-->
<div id="productDialog" closed="true" >
</div>

 <!--更新产品对话框-->
<div id="updateProductDialog" closed="true" >
</div>
</body>
</html>