<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Talan* | GR</title>

  <!-- Bootstrap core CSS -->

  <link href="resources/css/bootstrap.min.css" rel="stylesheet">

  <link href="resources/fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="resources/css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="resources/css/custom.css" rel="stylesheet">
  <link href="resources/css/icheck/flat/green.css" rel="stylesheet">


  <script src="resources/js/jquery.min.js"></script>



</head>


<body class="nav-md">

  <div class="container body">


    <div class="main_container">

      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><img src="resources/images/LogoTalan.jpg" height="40px" width="50px"> <span>&nbsp;&nbsp; TALAN</span></a>
          </div>
          <div class="clearfix"></div>


          

          <br />

          <!-- sidebar menu -->
          <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
              <h3>General</h3>
              <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i>Processus<span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="/GestionDesRisque_Web/ProcessAdd">Pocessus</a>
                    </li>
                    <li><a href="index2.html">Sous Pocessus</a>
                    </li>
                    <li><a href="index3.html">Activite</a>
                    </li>
                    <li><a href="index3.html">Information</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> Risque <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="form.html">Risque</a>
                    </li>
                    <li><a href="form_advanced.html">Confidentialite</a>
                    </li>
                    <li><a href="form_validation.html">Integrite</a>
                    </li>
                    <li><a href="form_wizards.html">Disponibilite</a>
                    </li>
                    <li><a href="form_upload.html">Mesure</a>
                    </li>
                    <li><a href="form_buttons.html">Vulnerabilite</a>
                    </li>
                     <li><a href="form_buttons.html">Impact/Consequence</a>
                    </li>
                  
                  </ul>
                </li>
                <li><a><i class="fa fa-desktop"></i>Utilisateur<span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="general_elements.html">Administrateur</a>
                    </li>
                    <li><a href="media_gallery.html">Responsable</a>
                    </li>
                    <li><a href="typography.html">Poste</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-table"></i> Action <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="tables.html">Action</a>
                    </li>
                    <li><a href="tables_dynamic.html">Alerte</a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
            

          </div>
          <!-- /sidebar menu -->

          <!-- /menu footer buttons -->
        
          <!-- /menu footer buttons -->
        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">

        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="resources/images/LogoTalan.jpg" alt="">John Doe
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="javascript:;">  Profile</a>
                  </li>
                 
                  <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </li>
                </ul>
              </li>

              <li role="presentation" class="dropdown">
                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-envelope-o"></i>
                  <span class="badge bg-green">6</span>
                </a>
                <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
          
                </ul>
              </li>

            </ul>
          </nav>
        </div>

      </div>
      <!-- /top navigation -->

      <!-- page content -->
			<div class="right_col" role="main">

				<div class="">
					<div class="page-title">


						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">

							</div>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel" style="height: 595px;">
								<div class="x_title">
									<h2>
										Gestion Des Risques <small>Talan</small>
									</h2>
								</div>
								
								        <div class="clearfix"></div>
             
                <div class="x_content">

                  <f:form class="form-horizontal form-label-left" method="post" modelAttribute="processus" action="AddProcessus" >

                  
                    <span class="section">Processus</span>

                    	 <div class="x_content">
                  <p class="text-muted font-13 m-b-30">
                  </p>
                  <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>Sub-Process</th>
                        <th>Activity</th>
                        <th>Information</th>
                        <th>Owner</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                    <tr>
                    	<td rowspan="3">sub 1</td>
                    	<td rowspan="3">
	                    	act 1
	                    </td> 
	                    <td>info 1</td>
	                    <td>owner 1</td>
                    </tr>
                   
                    <tr>
                    	
                    	<td>info 2</td>
                    	<td>owner 2</td>
                    </tr>
                    <tr>
                    	
                    	<td>info 3</td>
                    	
                    	<td>owner 3</td>
                    </tr>
                   
                    </tbody>
                    </table>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                      <div class="col-md-6 col-md-offset-3">
                        
                        <button id="send" type="submit" class="btn btn-success">Submit</button>
                      </div>
                    </div>
                  </f:form>
                </div>
								
					   </div>			
								
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

      <!-- footer content -->
      <footer>
        <div class="pull-right">
          Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
        </div>
        <div class="clearfix"></div>
      </footer>
      <!-- /footer content -->
    </div>
  </div>

  <div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
  </div>

  <script src="resources/js/bootstrap.min.js"></script>

  <!-- bootstrap progress js -->
  <script src="resources/js/progressbar/bootstrap-progressbar.min.js"></script>
  <!-- icheck -->
  <script src="resources/js/icheck/icheck.min.js"></script>
  <!-- pace -->
  <script src="resources/js/pace/pace.min.js"></script>
  <script src="resources/js/custom.js"></script>
  <!-- form validation -->
  <script src="resources/js/validator/validator.js"></script>
  <script>

  	$('#datatable').DataTable();
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
      .on('blur', 'input[required], input.optional, select.required', validator.checkField)
      .on('change', 'select.required', validator.checkField)
      .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
      .on('keyup blur', 'input', function() {
        validator.checkField.apply($(this).siblings().last()[0]);
      });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function(e) {
      e.preventDefault();
      var submit = true;
      // evaluate the form using generic validaing
      if (!validator.checkAll($(this))) {
        submit = false;
      }

      if (submit)
        this.submit();
      return false;
    });

    /* FOR DEMO ONLY */
    $('#vfields').change(function() {
      $('form').toggleClass('mode2');
    }).prop('checked', false);

    $('#alerts').change(function() {
      validator.defaults.alerts = (this.checked) ? false : true;
      if (this.checked)
        $('form .alert').remove();
    }).prop('checked', false);
  </script>

</body>

</html>