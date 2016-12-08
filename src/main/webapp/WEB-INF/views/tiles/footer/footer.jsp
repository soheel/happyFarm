<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<body>
	<footer class="wrap-footer footer-2 colophon wigetized">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-6 item-footer-four">
							<div class="widget widget_about"> 
								<div class="noo_about_widget">
									<a href="#">
										<img src='<c:url value="/resources/images/"/>logo.png' alt="" />
									</a>
									<p>
										Maecenas tristique gravida, odio et sagi ttis justo. Suspendisse ultricies nisi veafn. onec dictum non nulla ut lobortis tellus. 
									</p>
								</div>
							</div>
							<div class="widget widget_noo_social"> 
								<div class="noo_social">
									<div class="social-all">
										<a href="#" class="fa fa-facebook"></a>
										<a href="#" class="fa fa-google-plus"></a>
										<a href="#" class="fa fa-twitter"></a>
										<a href="#" class="fa fa-youtube"></a>
										<a href="#" class="fa fa-skype"></a>
									</div>
								</div>
							</div>
							<div class="widget widget_text">
								<div class="textwidget">
									<div class="copyright">
										2015 Oganici.<br/>
										Designed with <i class="fa fa-heart-o"></i> by TK-Themes.
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 item-footer-four">
							<div class="widget widget_text">
								<h4 class="widget-title">Contact</h4> 
								<div class="textwidget">
									<h5>Address</h5>
									<p>No 13, Sky Tower Street, New York, USA</p>
									<h5>Hotline</h5>
									<p>
										<a href="#">(+844) 123 456 78</a><br/>
										<a href="#">(+844) 888 97989</a>
									</p>
									<h5>Email</h5>
									<p>
										<a href="mailto:contact@organicistore.com">
											contact@organicistore.com
										</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-sm-6 item-footer-four">
							<div class="widget widget_noo_openhours">
								<h4 class="widget-title">Donate</h4> 
							</div>
							<div class="widget widget_noo_happyhours">
								<h4 class="widget-title">Happy Hours</h4> 
								<ul class="noo-happyhours">
									<li>
										<div>
											이번달
											<p><fmt:formatNumber value="123456789" groupingUsed="true"/>&nbsp;<i style="font-size:15px" class="fa">&#xf159;</i></p>
										</div>

										<div>
											저번달 
											<p><fmt:formatNumber value="123456789" groupingUsed="true"/>&nbsp;<i style="font-size:15px" class="fa">&#xf159;</i></p>										 
										</div>
										
										<div>
											<a href="<c:url value="/userEtcController/donationLoading"/>"><p>Show More</p></a>
										</div>
									</li>
								</ul>
								<span></span>
								<span></span>
								<span></span>
								<span></span>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>
	<a href="#" class="go-to-top hidden-print"><i class="fa fa-angle-up"></i></a>
</body>
</html>