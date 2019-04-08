oop-2019-uto-18-b-kanuch-emarich created by GitHub Classroom

# ZADANIE PROJEKTU 

E-správa (E-Governance)

Okrem podpory a zabezpečenia demokratickosti vládnutia (e-government), informačné a komunikačné technológie umožňujú aj podporu množstva ďalších procesov súvisiacich so štátnou správou. Tzv. e-správa (e-governance) zahŕňa podporu akýchkoľvek procesov medzi štátnou alebo lokálnou správou a fyzickými alebo právnickými osobami. Môže sa to týkať pobytu, nehnuteľností, zamestnania, finančnej podpory, školstva a pod.

Príklady e-správy zahŕňajú elektronické zabezpečenie podávania žiadosti o víza a udeľovania víz, komunikácie s finančnou správou, resp. s jej ľubovoľnou sekciou (daňový, živnostenský, colný úrad a pod.), poradenstva pre študentov študujúcich v zahraničí, registrácie privezeného dopravného prostriedku zo zahraničia a podania daňového priznania.


# ZAMER PROJEKTU

ECO - Electronic cadastral office

Ema Richnáková

Projekt je zameraný na spravovanie pozemkov, nehnuteľností na daných pozemkoch a príslušných práv k nim určených.

Program bude slúžiť Katastrálnemu úradu spravovať verejný register pozem\-kov a nehnuteľností a poskytne lepší prehľaď o právnych úkonoch, ktoré sú spojené so správou. Do tejto činnosti sa zahŕňa evidovanie pozemkov a stavieb; členenie pozemkov; zapisovanie práv k pozemkom a nehnuteľnostiam; evidovanie majiteľov; spracovanie požiadavok o prevode vlastníckeho práva, zahŕňajúc kúp\-nu zmluvu, darovaciu zmluvu, zámennú zmluvu pozemkov; komunikácia s Úra\-dom geodézie, kartografie a katastra ohľadom stavebnej činnosti; komunikácia s Daňo\-vým úradom ohľadom výpočtu sumy dane za pozemok a nehnuteľnosť; zmena hraníc území; ukladanie pokút za niektoré priestupky na úseku geodézie a katastra.

Program taktiež bude slúžiť občanom. Občan, ktorý nebude registrovaný v danom programe, bude môcť prehľadávať parcely a bude mať prístup k vlastníkov a ich údajom. Registrovaný občan bude môcť komunikovať s úradmi spomenutý\-mi vyššie, podávať rôzne žiadosti týkajúce sa správy jeho vlastníctva, vystavovať zmluvy.


# Implementovaná funkcionalita

(pri spusteni programu sa do terminálu vypíšu existujúci použivatelia a ich typy... heslá nie sú podstatné, stačí jedno písmeno zadať)
- registrácia nového použivateľa z prvej scény, z "Guest-a" a aj z "Office-u" (+ zabezpečenie zlých inputov od používateľa)
- prihlásenie a odhlásenie použivateľov (+ zabezpečenie zlých inputov od používateľa)
- v Office scéne sa dá vytvoriť v objekte User inštancia triedy Owner (čiže má priradené ešte navyše nejaké atritubúty a hlavne bude si vedieť ukladať v sebe inštancie z tried Land a RealEstate)
- (v Office momentálne nejde vytváranie pozemkov)


# Implementácia vecí z hodnotenia

- DEDENIE - v package Offices - CadastralOffice a GeodesyOffice dedia od Office
          - v package Owners - City a Owner dedia od Ownership
- POLYMORFIZMUS - v package Owners - v metóde addLand sa mení typ pozemku podľa typu ownera
- AGREGÁCIA - trieda User agreguje objekt triedy Ownership (a taktiež enum UserType)
            - trieda Ownership agreguje array triedy Land a RealEstate
            - agregacia je aj v triedach Land, Office, CadastralOffice, City, Owner (tam je vnutorna trieda), ... 
- ENKAPSULÁCIA - asi v každom balíku je aspoň 1 trieda, ktorá využíva enkapsuláciu
- VISITOR - v balíku ViewControllers trieda MakeOwnerController metóda btnClicked
