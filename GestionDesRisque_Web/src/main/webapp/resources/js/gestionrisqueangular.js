

$.ajax({
    url:'/GestionDesRisque_Web/SeekUsers',
    dataType:'text',
    type:'get',
    async:false,
    success: function(data) {
        console.log(data);
    }
});
