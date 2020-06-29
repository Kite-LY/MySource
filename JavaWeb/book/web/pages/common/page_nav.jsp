<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/30
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--当在首页的时候不显示首页，和上一页--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo + 1}</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第
    <input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBth" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            //跳到指定的页码,当点击确定按钮时（加#号才可以对应到相应id）
            $("#searchPageBth").click(function () {
                //获取输入的页数
                var pageNo = $("#pn_input").val();
                //进行页码的判断如果页码输入不正确进行自动赋值
                /**
                 * 最好在服务器端进行判断
                 * @type {string}
                 */
                <%--if($("#pn_input").val() < 1){--%>
                <%--pageNo = 1;--%>
                <%--}else if($("#pn_input").val() > ${requestScope.page.pageTotal}){--%>
                <%--pageNo = ${requestScope.page.pageTotal};--%>
                <%--}--%>


                //JavaScript中提供一个location地址栏对象
                //有一个属性href，可以获取浏览器地址栏中的地址
                //而且href可以进行读写
                //这时点击确定按钮就会跳转到href对应的地址
                location.href="${requestScope.basePath}/${requestScope.page.url}&pageNo=" + pageNo;
            });

        })
    </script>

</div>