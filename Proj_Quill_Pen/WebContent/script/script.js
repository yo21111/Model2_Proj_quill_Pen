/**
 * 
 */

$(function(){
	
	$("#idChkBtn").click(function(){
		
		let chkId = $("#idChkInput").val();
		
		let root = "/Proj_Quill_Pen/register?check=" + chkId;
		
		let width = screen.width;
		let popWidth = 400;
		let leftPos = (width - popWidth) / 2;

		let height = screen.height;
		let popHeight = 200;
		let topPos = (height - popHeight) / 2;
		
		let prop = "width=" + popWidth + ", height=" + popHeight + ", left=" + leftPos + ", top=" + topPos;
		
		window.open(root,prop);
				
	});
	
	
	$("#writerChkBtn").click(function(){
		
		let chkWriter = $("#writerChkInput").val();
		
		let root = "/Proj_Quill_Pen/register?check=" + chkWriter;
		
		let width = screen.width;
		let popWidth = 400;
		let leftPos = (width - popWidth) / 2;

		let height = screen.height;
		let popHeight = 200;
		let topPos = (height - popHeight) / 2;
		
		let prop = "width=" + popWidth + ", height=" + popHeight + ", left=" + leftPos + ", top=" + topPos;
		
		window.open(root,prop);
				
	});
	
	
});