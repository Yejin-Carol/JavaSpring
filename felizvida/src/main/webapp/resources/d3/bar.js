var dataSet =  [];

d3.csv('http://localhost:8090/felizvida/resources/csv/mydata.csv', function(err,data) 
{
	dataSet = [];
	for(i=0; i<160; i=i+20) {
	//	console.log("i = "+i);
		//console.log("data[i].Weight = "+data[i].Weight)
		dataSet.push(data[i].Weight/4);//
		
	}
	d3.select("#myGraph1")
  .selectAll("rect")
  .data(dataSet)
  .enter()
  .append("rect")
  .attr("class","bar")
  .attr("x",10)
  .attr("y",function(d,i){
      return i*45+10;
  })
  .attr("width", function(ele,i){ return ele;})
  .attr("height",30)
 });

d3.select("#barBtn")
  .on("click",function(){
    d3.selectAll("rect")
    	.transition()
    	.duration(5000)
    	.attr("width", function(){
        	return (Math.random()*300)+1;
    })
});/**
 * 
 */