<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section class="noo-page-heading eff heading-2">
	<div class="container">
		<div class="noo-heading-content">
			<h1 class="page-title eff">Shop Detail</h1>
			<div class="noo-page-breadcrumb eff">
				<a href="./" class="home">Organici</a>/<span>Shop Detail</span>
			</div>
		</div>
	</div>
</section>
<div class="main">
	<div class="commerce single-product noo-shop-main">
		<div class="container">
			<div class="row">
				<div class="noo-main col-md-9">
					<div class="product">
						<div class="single-inner">
							<div class="images">
								<div class="product-simple-image">
									<a href="<c:url value="/resources/images/"/>product/product_405x515.jpg" data-rel="prettyPhoto"> 
										<img width="300" height="381" src="<c:url value="/resources/img/product/"/>${product.profile}" alt="" />
									</a>
								</div>
							</div>
							<div class="summary entry-summary">
								<input id="product_no" type="hidden" value="${product.no }">
								<h1 class="product_title entry-title">${product.name}</h1>
								<p class="price">
									<span class="amount"><fmt:formatNumber
											value='${product.price}' pattern='#,###' /></span> 원
								</p>
								<div class="product_meta">
									<span class="posted_in">Category: <a href="#">${categoryName }</a></span>
									<span class="posted_in">Unit: <a href="#">${product.unit }</a></span>
									<span class="posted_in">Producer: <a href="#">${producer.name }</a></span>

								</div>
								<form
									action="<c:url value = '/userProductController/purchaseAop?productNo=${product.no}&producerNo=${producer.no}&price=${product.price}'/>"
									method="post" class="cart">
									<div class="quantity">
										<input id="product_num" type="number" step="1" min="1"
											name="quantity" value="1" title="Qty"
											class="input-text qty text" size="4" />
									</div>
									<input type="button" id="addToCart" value="Add to Cart"
										class="single_add_to_cart_button button" />
									<button type="submit" class="single_add_to_cart_button button">Purchase</button>
								</form>
								<div class="clear"></div>

							</div>
						</div>
						<div class="commerce-tabs">
							<ul class="nav nav-tabs tabs">
								<li class="active"><a data-toggle="tab" href="#tab-1">Product</a>
								</li>
								<li><a data-toggle="tab" href="#tab-2">Reviews</a></li>
								<li><a data-toggle="tab" href="#tab-3">Producer</a></li>
							</ul>
							<div class="tab-content">
						
							<div class="tab-pane fade in active" id="tab-1">
								<div class="row">
									<div class="col-md-12 organic_food">
										<div class="product_detail_header">
											<div class="name">
												해당 상품의 유기농 인증 정보 
											</div>
										</div>
										<div class="product_detail">
											<ul>
											<!--
												product_img : 이미지 나옴
												product_info : 이미지에 대한 정보 표시
											 -->
											<c:forEach items="${productCerti}" var="certi">
												<li class="product_img">
													<img src='<c:url value="/resources/img/certification/${certi.certificationDTO.image}"/>' alt="agricultural produce">
												</li>
												<li class="product_info">
													<dl>
														<dt> 유기농 고유 번호 : ${certi.no}</dt>
														<dd> ${certi.certificationDTO.name} (제${certi.certificationNo}호)</dd>
														<dd>${certi.certificationDTO.desc}</dd>
													</dl>
												</li>
											</c:forEach>	
										</ul>
											</div>
										</div>
									</div>
									<img alt=""
										src="<c:url value='/resources/img/product/'/>${product.desc }">
								</div>
								<div id="tab-2" class="tab-pane fade">
									<div id="comments" class="comments-area">
										<h2 class="comments-title">2 Comments</h2>
										<ol class="comments-list">
											<li class="comment">
												<div class="comment-wrap">
													
													<article class="comment-block">
														<header class="comment-header">
															<cite class="comment-author"> dlarmsanr </cite>
															<div class="comment-meta">
																<span class="time"> 2016-12-24 19:31:23 </span>
															</div>
														</header>
														<div class="comment-content">
															<p>이거 너무 맛있어서 다음에도 또 주문해서 먹을 것 같아요!</p>
														</div>
														<span class="comment-reply"> <a
															class='comment-reply-link' href='#'><i
																class="fa fa-reply"></i> Reply</a>
														</span>
													</article>
												</div>
												<ol class="children">
													<li class="comment">
														<div class="comment-wrap">
															
															<article class="comment-block">
																<header class="comment-header">
																	<cite class="comment-author"> admin </cite>
																	<div class="comment-meta">
																		<span class="time"> 2016-12-24 19:31:23 </span>
																	</div>
																</header>
																<div class="comment-content">
																	<p>감사합니다!</p>
																</div>
																<span class="comment-reply"> <a
																	class='comment-reply-link' href='#'><i
																		class="fa fa-reply"></i> Reply</a>
																</span>
															</article>
														</div>
													</li>
													<!-- #comment-## -->
												</ol>
												<!-- .children -->
											</li>
										</ol>
										<!-- /.comments-list -->
										<div id="respond-wrap">
											<div id="respond" class="comment-respond">
												<h3 id="reply-title" class="comment-reply-title">
													<span>Leave your thought</span>
												</h3>
												<form class="comment-form">
													<div class="row">
														<div class="col-sm-12">
															<div class="comment-form-comment">
																<textarea class="form-control"
																	placeholder="Enter Your Comment" id="comment"
																	name="comment" cols="40" rows="6"></textarea>
															</div>
														</div>
													</div>
													<div class="form-submit">
														<input name="submit" type="submit" id="submit"
															class="submit" value="Post Comments" />
													</div>
												</form>
											</div>
											<!-- #respond -->
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab-3">
									<div><div></div> <div></div></div>
									<img style="width: 200px; height: 200px; margin: auto;" alt=""
										src="<c:url value='/resources/img/producer/'/>${producer.profile}">
									<p>생산자 이름 : ${producer.name }</p>
									<p>생산자 연락처 : ${producer.phone}</p>
									<p>
										생산지 : <span id="producer_addr">${producer.addr}</span>
									</p>
									<div id="mapDiv" style="width: 500px; height: 400px;"></div>
									

								</div>
							</div>
						</div>
						<div class="related products">
							<p>본 상품 가격의</p>
							<p>10%는 마일리지로적립됩니다.</p>
							<img src='<c:url value="/resources/images/"/>double_quote.png'
								class="absolute reverse_img quote quote_left"> <img
								src='<c:url value="/resources/images/"/>double_quote.png'
								class=" absolute quote quote_right">
						</div>
					</div>
				</div>

				<script type="text/javascript"
					src="//apis.daum.net/maps/maps3.js?apikey=a4323905bc104c7f43e6f2c4a13baa6b&libraries=services"></script>
				<script type="text/javascript">
		var addr = document.getElementById('producer_addr').innerHTML;
		 // 다음 지도
	    var geocoder = new daum.maps.services.Geocoder();
	    var callback = function(status, result) {
	        if (status === daum.maps.services.Status.OK) {
	        	var container = document.getElementById('mapDiv');
	        	var options = {
	        		center: new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng),
	        		level: 3
	        	};

	        	var map = new daum.maps.Map(container, options);
	        }
	    };
	    geocoder.addr2coord(addr, callback); // db에서 꺼내온 주소를 addr2coord함수의 첫번째 인수에 문자열로 넣어줌
		</script>