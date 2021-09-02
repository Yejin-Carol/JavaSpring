var dataSet =  [];

d3.select("#myGraph2")
  .selectAll("rect2")
  .data(dataSet)
  .enter()
  .append("rect2")
  .attr("class","bar")
  .attr("x",10)
  .attr("y",function(d,i){
      return i*45+10;
  })
  .attr("width", function(ele,i){ return ele;})
  .attr("height",30)
 
d3.select("#pieBtn")
  .on("click",function(){
    d3.selectAll("rect2")
    	.transition()
    	.duration(5000)
    	.attr("width", function(){
        	return (Math.random()*300)+1;
    })
});/**
 * 
 */