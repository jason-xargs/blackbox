<#if result?exists && result.message?exists>
<font color="red">${result.message!""}</font>
</#if>
</br>
<button type="button" onclick="smoking()">Smoking</button>
<table>
    <tr>
        <th>time</th>
    </tr>
<#if result?exists>
    <#list result.content as time>
        <tr>
            <td>${time}</td>
        </tr>
    </#list>
</#if>

</table>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

    function smoking() {
        $.ajax({
            type: 'POST',
            url: '/addOne',
            success: function (data) {
                if (data.success == true) {
                    alert('Saved!')
                    window.location.reload()
                }
                else
                    alert(data.message)
            }
        })
    }

</script>