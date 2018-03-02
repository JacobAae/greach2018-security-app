<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="webshop.title"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Workshops R us</h1>
    </section>

    <div class="row">
        <section class="col-lg-8">

            <g:if test="${flash.message}">
                <div class='alert alert-success' role='alert'>
                    <strong>${flash.message}</strong>
                </div>
            </g:if>
            <g:if test="${flash.error}">
                <div class='alert alert-danger' role='alert'>
                    <strong>${flash.error}</strong>
                </div>
            </g:if>

            <div class="well">

                <p>Only 1000 pr student without discount</p>
                <g:form action="index" method="POST">
                    <div class="form-group">
                        <label for="students">Number of students</label>
                        <input type="number" class="form-control update-total" id="students" name="students" placeholder="Number of students">
                    </div>
                    <div class="form-group">
                        <label for="discount">Discount code</label>
                        <input type="text" class="form-control update-total" id="discount" name="discount" placeholder="Discount Code">
                    </div>
                    <div class="form-group">
                        <label for="total">Total trice</label>
                        <input type="number" class="form-control" id="total" name="total" placeholder="Total" disabled>
                    </div>
                    <button type="submit" class="btn btn-primary">Order</button>
                </g:form>



            </div>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>
                <p>Can you find a way to save money on the workshop order?</p>

                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Searching on Google for the discount code is maybe not necessary.</div>

                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">Try to study the source code for this page.</div>

                <br>

                <a href="#" class="hint"><strong>Hint 3:</strong></a>
                <div style="display: none;">Have you checked the javascript calculating the price</div>

            </div>
        </section>
    </div>
</div>

<g:javascript>
    $("input.update-total").on('keyup change', function() {
        var students = $("#students").val();
        var total = students * 1000;
        if( $("#discount").val() == 'MuchTooNice' ) {
            total = total * 0.1;
        }
        $("#total").val(total);
    });

    $("a.hint").on('click', function() {
        $(this).next('div').slideDown();
        return false;
    })
</g:javascript>

</body>
</html>