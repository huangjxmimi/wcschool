/**
 * Created by xingli on 2016/3/30.
 */
var flag =false;
$(document).ready(function()
{
	$("ui-container").css("overflow","auto");
    $("#listMenu").css("overflow","auto");
    $("#navMenu").click(function()
    {

        if(flag==true)
        {
            $("#listMenu").addClass("uhide");
            flag=false;
            $(document.body).css("pointer-events","auto")
            $(document.body).css("overflow","auto");
        }
        else
        {
            $("#listMenu").removeClass("uhide");
            flag=true;
            $(document.body).css("pointer-events","none");
            $(document.body).css("overflow","hidden");

        }
    });
    $(".metro").click(function()
    {
        alert(2);
    })

    $(".ubb").click(function()
    {
        alert(4);
    })
})
