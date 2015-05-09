package com.bzu.gxs.main;

/*

1.����������Ҫ�������� xml�ļ� 
      ��activity_main.xml�д���һ��ListView
      ͼ Ƭ  
      ���룺
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" >
    
    <ListView 
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        ></ListView>

</RelativeLayout>      

    ��fruit_item�д���һ�� ImageView ��һ��TestView ���
    ͼƬ
   ���룺
<?xml version="1.0" encoding="utf-8"?><LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal" >

    <ImageView
        android:id="@+id/ivFruit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/apple_pic" />

    <TextView
        android:id="@+id/tvFruit"
        android:layout_gravity="center"
        android:layout_margin="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Apple" />
</LinearLayout>



����java����

��MainActivity.java
��1������Ҫ׼���� ����Դ�����������Դָ��������Ҫ�õ���һЩͼƬ��������Ϣ�����ǰ�����װ����List�У�����ʹ��
��2������Adapter������   FruitAdapter adapter=new FruitAdapter( ��ǰ�ı� , fruit_item���� , �����Ϣ��List���� );
��3����AdapterView��Adapter  
ע�⣺
Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
����һ������¼�����ʾ��ǰһ��ˮ�������ƣ����� ��˿ �����ʾˮ��������
FruitAdapter ��һ���Զ����Adapter
�������£�
package com.example.ui_listview01;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.example.ui_listview01.adpater.FruitAdapter;
import com.example.ui_listview01.model.Fruit;
public class MainActivity extends Activity {
	private ListView lvFruits;
	//1.׼��������Դ
	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//1.׼��������Դ
		initFruits();
		
		lvFruits = (ListView) findViewById(R.id.lvFruits);
		
		//2.����Adapter
        FruitAdapter adapter=new FruitAdapter(this, R.layout.fruit_item,fruitList);
        
        //3.��AdapterView��Adapter֮��Ĺ���
		lvFruits.setAdapter(adapter);
		lvFruits.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position,
					long id) {
			    Fruit fruit=	fruitList.get(position);
			    Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}
		});
		
	
	}
	private void initFruits() {
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);

	}
}


FruitAdapter.java
��1��FruitAdapter�����̳�ArrayAdapter ��Ҫ��дgetView����
��2��getView()���������ÿ�������������Ļ�ڵ�ʱ��ᱻ���� getView( ��ǰλ��, View convertView, ViewGroup parent)

ע�⣺��FruitAdapter��getView()������ÿ�ζ����������¼�����һ�飬��ListView���ٹ�����ʱ����ͻ��Ϊ���ܵ�ƿ��
�������£�
package com.example.ui_listview01.adpater;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ui_listview01.R;
import com.example.ui_listview01.model.Fruit;

public class FruitAdapter extends ArrayAdapter<Fruit> {
	private int resourceId;
	public FruitAdapter(Context context, int textViewResourceId,List<Fruit> data) {
		super(context, textViewResourceId, data);
		resourceId=textViewResourceId;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit fruit = getItem(position);
		View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView ivFruit=(ImageView) view.findViewById(R.id.ivFruit);
		TextView tvFruit=(TextView) view.findViewById(R.id.tvFruit);
		ivFruit.setImageResource(fruit.getImageId());
		tvFruit.setText(fruit.getName());
		return view;
	}

}

*/