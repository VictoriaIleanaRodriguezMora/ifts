siempre que creo un nuevo activity, tiene que estar dentro del manifest 
el manifest es un archivo de configuracion donde tiene todo los parametros, metadata de la aplicacion. 

entre ellas los activitys y los permisos

manifiesto de las propiedades que va a tener la app

Agrego un activity
```xml
<activity
            android:name=".ResultadoActivity"
            android:exported="false"
            android:theme="@style/Theme.Clase_09"
            />

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.Clase_09">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```