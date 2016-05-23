 $(".data").each(function(){
      var $this = $(this);
      $this.html($this.text().replace(/(\r\n|\r|\n)/g, '<br />'));
    });
