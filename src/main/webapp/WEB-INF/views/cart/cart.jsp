<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">My Cart</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">HappyFarm</a>/<span>Cart</span>
					</div>
				</div>
			</div>
	</section>
	<div class="main">
		<div class="commerce commerce-page commerce-cart noo-shop-main">
			<div class="container">
				<div class="row">
					<div class="noo-main col-md-12">
					<form action="<c:url value = '/userProductController/purchaseCart'/>" method="post">
						<table class="shop_table cart">
							<thead>
								<tr>
									<th class="product-check">
										<div class="checks etrans">
  											<input type="checkbox" id="checkAll" checked="checked">
  											<label for="checkAll"></label> 
  										</div>
									</th>
									<th class="product-thumbnail">Image</th>
									<th class="product-price">Price</th>
									<th class="product-quantity">Quantity</th>
									<th class="product-subtotal">Total</th>
									<th class="product-remove">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							
							<c:forEach items="${productList}" var="product" varStatus="status">
								<!-- 상품 하나하나 -->
								<tr class="cart_item">
									<td class="product-check">
										<div class="checks etrans checkboxs">
  											<input name = "checkbox" type="checkbox" id="ex_chk1${product.no}" checked="true">
  											<label for="ex_chk1${product.no}"></label> 
  										</div>
									</td>
									<td class="product-thumbnail">
										<a href="shop-detail.html">
											<img width="100" height="100" src="<c:url value="/resources/img/product/"/>${product.profile}" alt="" />
										</a>
										<input name = "list[${status.index}].productNo" type = "hidden" value = "${product.no }">
										<a href="shop-detail.html">${product.name} </a> 
									</td>
									<td class="product-price">
										<span class="amount"><fmt:formatNumber value = '${product.price}'/></span> 
									</td>
									<td class="product-quantity">
										<div class="quantity">
											<input type="number" step="1" min="0" name = "list[${status.index}].num" value="${product.cartDto.num }" class="input-text qty text" size="4"/>
											<input type = "hidden" value = "${product.cartDto.num}"> 
										</div>
									</td>
									<td class="product-subtotal">
										<span class="amount"><fmt:formatNumber value = '${product.cartDto.num * product.price}'/></span> 
									</td>
									<td class="product-remove">
										<a href="<c:url value='/userInfoController/myCartDelete?name='/>${product.name}" id = "cart_remove" class="remove">&times;</a>
									</td>
								</tr>
							<!-- 상품 하나하나 -->
							</c:forEach>
								<!-- 선택 상품들 총 금액 -->
								<tr>
									<td colspan="6" class="actions">
										<div class="cart-action">
											<p>
												<input type = "hidden" name = "totalPrice" value = "${totalPrice }">
												<label>총 금액 : <span id = "totalPrice"><fmt:formatNumber value='${totalPrice}'/></span>원</label>
											</p>
											<input id = "selectOrder" type="submit" class="button" name="update_cart" value="선택상품주문"/>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/img/footer/"/>organici-love-me.png" class="noo-image-footer" alt="" />
		</div>
	</div>