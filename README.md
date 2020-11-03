# leecode

```
// 1. 查出所有门店编号
SQL : SELECT stroeId DISTINCT FROM xxx;
结果返回的是一个编号列表，存储在数组中（storeids）,storeIds的内容是[9,1,8,3,7...]

// 2. 逐个门店统计菜品数据
Map<storeId,Map<item,quantity> firstMap; // 保存所有门店的信息
for(long id : storeIds){
	// 2.1 查询当前门店的所有订单,返回的是门店所有订单的菜品与数量对应(orders),
	SELECT "name of items","quantity" FROM xxx WHERE storeId = id;(这个id是遍历的门店ID)
	// orders的内容是[ ["ice coffe,Cappuccino,toast","1,3,2"],...]
	
	// 2.2 为每个门店间一个Map数据结构，key是菜品名称，value是菜品数量
	Map<item,quantity> map;
	
	// 2.3 遍历当前门店所有的订单
	for(Array itemAndQuan :  orders){
		// 拿到菜品和数量
		String item = itemAndQuan[0];
		String quan  = itemAndQuan[1];
		// 拆分字符串
		str[] items = item.split(',');
		str[] quantitys = quan.split(',');
		// 保存到map中
		for(int i=0; i<items.length; i++){
			int value;
			if( (value = map.get(tems[i]) )==null){
				map.set(items[i],Integer.parss(quantitys[i]));
			}else{
				int newValue = value + Integer.parss(quantitys[i]);
				map.set(items[i],newValue);
			}
		}
	}
	
	// 处理完当前门店订单信息后，将门店的菜品与数量的对应信息保存到大的Map中
	firstMap.set(id, map);		
}

// 最后得到的是所有统计信息，大致内容如下

storeId:
	item: quantity;
----------------------------
9 :
	ice coffee : 100,
	Cappuccino: 23;
	...
1 : 
	ice coffee : 100,
	Cappuccino: 23;
	...
...
	
```
