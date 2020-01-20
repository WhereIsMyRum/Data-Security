<html>
<body>
<h1 class="title">JSON web token authetication and authorization</h1>
<h3 class="why">Powód</h3>
<p class="why">Niniejszy projekt powstał w ramach przedmiotu Data Security moich podczas studiów magisterskich (kierunek Informatyka - Computer Science and Engineering) na Duńskim Uniwersytecie Technicznym.</p>
<h3 class="what">Cel</h3>
<p class="what">Celem projektu było zaprojektowanie i zaimplementowanie prostegu interfejsu dla drukarki, którego metody mogą być wywołýwane zdalnie. Interfejs powinien być odpowiednio zabezpieczony przed nieuwierzytelnionymi użytkownikami. Ponadto, różni użytkownicy posiadją różne uprawnienia, a więc konieczny jest również mechanizm autoryzacji.</p>
<h3 class="how">Wykonanie</h3>
<p class="how">Zarówno uwierzytelnianie jaki i autoryzacja zostały zaimplementowane przy użyciu JWT (JSON Web Token). W celu wywoływania którejś z metod interfejsu, użytkownik musi potwierdzić swoją tożsamość okazując ważny token. W celu jego uzyskania, konieczne jest zalogowanie. Login oraz hasło, które zostało uprzednio poddane hashowaniu przy wykorzystaniu tzw. soli (ang. salted hash). Przy każdym wywołaniu metody, użytkownik musi okazać token, którego ważność potwierdza serwer. Uprawnienia użytkowników przetrzymywane są, podobnie jak hasła, w pliku tekstowym na serwerze. W pliku tym znajdują się informacje odnośnie tego, jakie metody dany użytkownik może wywoływać, zgodnie z dostarczoną specyfikacją.</p>
<h3 class="technologies">Zastosowane technologie</h3>
<ul class="technologies">
  <li class="technologies">Java</li>
  <li class="technologies" hover="JSON Web Token">JWT</li>
  <li class="technologies" hover="Remote Method Invocation">RMI</li>
</ul>
<hr>
<small class="created">Data powstania: November 2018</small>
</body>
</html>
