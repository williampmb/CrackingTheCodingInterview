#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <string.h>
#include <unistd.h>

#define MAX_STR_SIZE	5
#define MIN_STR_SIZE	4
#define TAM_INI 		25
#define TRUE			1
#define FALSE			0
//compilar com -std=c99

typedef struct {
	char * nome;
	int idade;
	float altura;
}pessoa;
	
typedef struct{
	pessoa* no;
	struct arv* aesq;
	struct arv* adir;
}arv;

typedef struct{
	pessoa* item;
	struct lista* next;
}lista;

char* nomeRandomico();

int altura(arv* a);

int diferencaAltura(arv* a);

arv* rotacaoDuplaDireita( arv* noPai);

arv* rotacaoDuplaEsquerda(arv* noPai);

arv* rotacaoDireitaEsquerda(arv* noPai);

arv* rotacaoEsquerdaDireita(arv* noPai);

arv* balanceamento(arv* a);

arv* inserirPorIdade(arv* raiz, pessoa* novo);

arv* inserirPorNome(arv* raiz, pessoa* novo);

arv* inserirPorAltura(arv* raiz, pessoa* novo);

pessoa* criarPessoaAleatoria();

void emOrdem(arv* a);

void preOrdem(arv* a);

lista* listaEmOrdem(arv* a);

void imprimirLista(lista* l);

lista* prioridadeIdadeNome(lista* l);

lista* prioridadeIdadeAltura(lista* l);

lista* prioridadeNomeIdade(lista* l);

lista* prioridadeNomeAltura(lista* l);

lista* prioridadeAlturaNome(lista* l);

lista* prioridadeAlturaIdade(lista* l);

int main (){
	srand(time(NULL));
	arv* arvIdade  = NULL;
	arv* arvNome = NULL;
	arv* arvAltura = NULL;
	lista* listaOrdenada = NULL;
	pessoa* estranho;
	int menu = 0;
	int submenu =0;
	int height =0;
	
	
	for(int i =0; i<TAM_INI; i++){
		estranho = criarPessoaAleatoria();
		if(i<5){
			estranho->idade = 15;
		}if(i<11&&i>=5){
			//use letras minusculas para o nome para nao ter problema com o strcmp
			estranho->nome ="jose";
		}if(i<16&&i>=10){
			estranho->altura =1.70;
		}
		arvNome = inserirPorNome(arvNome,estranho);	
		arvIdade = inserirPorIdade(arvIdade,estranho);	
		arvAltura = inserirPorAltura(arvAltura,estranho);
		
	}

	while(1){
	menu = 0;
	printf("-------------------------------------\ \n");
	printf("Filtragem de Objetos\n");
	printf("1 - Imprimir arvore filtrada pelo nome.\n");
	printf("2 - Imprimir arvore filtrada pela idade.\n");
	printf("3 - Imprimir arvore filtrada pela altura.\n");
	printf("4 - Imprimir arvore filtrada pelos elementos idicados pelo usuario.\n");
	printf("5 - Imprimir a altura das Arvores.\n");
	printf("6 - Sair.\n");
	printf("Selecione um iem de menu: ");
	scanf("%d",&menu);
	
	if(menu == 2){
		emOrdem(arvIdade);
	}else if( menu == 1){
		emOrdem(arvNome);
	}else if(menu == 3){
		emOrdem(arvAltura);
	}else if(menu ==4){
		while(1){
			submenu = 0;
			printf("-------------------------------------\ \n");
			printf("Menu de filtragem por prioridades.\n");
			
			printf("1 - Prioridade nome seguido por idade.\n");
			printf("2 - Prioridade nome seguido por altura.\n");
			printf("3 - Prioridade idade seguido por nome.\n");
			printf("4 - Prioridade idade seguido por altura.\n");
			printf("5 - Prioridade altura seguido por nome.\n");
			printf("6 - Prioridade altura seguido por idade.\n");
			printf("7 - Retornar.\n");
			printf("Selecione um iem de menu: ");
			scanf("%d",&submenu);
			
			if(submenu == 1){
				
				listaOrdenada = listaEmOrdem(arvNome);
				
				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeNomeIdade(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
				
				
			}else if(submenu==2){
				
				listaOrdenada = listaEmOrdem(arvNome);
				imprimirLista(listaOrdenada);
				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeNomeAltura(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
			
			}else if(submenu==3){
				
			listaOrdenada = listaEmOrdem(arvIdade);

				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeIdadeNome(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
			}else if(submenu==4){
				
				listaOrdenada = listaEmOrdem(arvIdade);
				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeIdadeAltura(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
				
				
			}else if(submenu==5){
				listaOrdenada = listaEmOrdem(arvAltura);
				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeAlturaNome(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
				
				
			}else if(submenu==6){
				
				listaOrdenada = listaEmOrdem(arvAltura);
				if(listaOrdenada != NULL){
					listaOrdenada = prioridadeAlturaIdade(listaOrdenada);
					imprimirLista(listaOrdenada);
				}
			
			}else if(submenu == 7){
				break;
			}
		
			
		}
		
		
	}else if(menu == 5){
		int height = altura(arvNome);
		printf("Altura da Arvore por Nome eh: %d\n", height);
		height = altura(arvIdade);
		printf("Altura da Arvore por Idade eh: %d\n", height);
		height = altura(arvAltura);
		printf("Altura da Arvore por Altura eh: %d\n", height);
	}else if(menu == 6){
		return 0;
	}

	}


}

int diferencaAltura(arv* a){
	int alturaArvEsquerda = altura(a->aesq);
	int alturaArvDireita = altura(a->adir);
	int bFator = alturaArvEsquerda - alturaArvDireita;
	return bFator;
}

int altura(arv* a){
	int alt =0;
	if(a != NULL){
		int alturaArvEsquerda = altura(a->aesq);
		int alturaArvDireita = altura(a->adir);
		int max = (alturaArvEsquerda > alturaArvDireita) ? alturaArvEsquerda : alturaArvDireita;
		alt = max + 1;
	}
	return alt;
}


char* nomeRandomico(){
	char *validchars = "abcdefghijklmnopqrstuvwxyz";
	char *novastr;
	register int i;
	int str_len;
	
	str_len = (rand() % MAX_STR_SIZE );
	str_len += ( str_len < MIN_STR_SIZE ) ? MIN_STR_SIZE : 0;

	novastr = ( char * ) malloc ( (str_len + 1) * sizeof(char));

	for (i = 0; i < str_len; i++ ) {
		novastr[i] = validchars[ rand() % strlen(validchars) ];
		novastr[i + 1] = 0x0;
	}

	return novastr;
}

arv* rotacaoDuplaDireita( arv* noPai){
	arv* no;
	no = noPai->adir;
	noPai->adir = no->aesq;
	no->aesq = noPai;
	return no;
}

arv* rotacaoDuplaEsquerda(arv* noPai){
	arv* no;
	no = noPai->aesq;
	noPai->aesq = no->adir;
	no->adir = noPai;
	return no;
}

arv* rotacaoDireitaEsquerda(arv* noPai){
	arv* no;
	no = noPai->adir;
	noPai->adir = rotacaoDuplaEsquerda(no);
	return rotacaoDuplaDireita(noPai);
}

arv* rotacaoEsquerdaDireita(arv* noPai){
	arv* no;
	no = noPai->aesq;
	noPai->aesq = rotacaoDuplaDireita(no);
	return rotacaoDuplaEsquerda(noPai);
	
}

arv* balanceamento(arv* a){
	int bFator = diferencaAltura(a);
	if(bFator >1){
		if(diferencaAltura(a->aesq)>0){
			a = rotacaoDuplaEsquerda(a);
		}else{
			a = rotacaoEsquerdaDireita(a);
		}
	}else if(bFator <-1){
		if(diferencaAltura(a->adir)>0){
			a = rotacaoDireitaEsquerda(a);
		}else{
			a = rotacaoDuplaDireita(a);
		}
		
	}
	return a;		
}

arv* inserirPorIdade(arv* raiz, pessoa* novo){
	
	if(raiz ==NULL){
		raiz = (arv*) malloc(sizeof(arv));
		raiz->no = (pessoa*) malloc(sizeof(pessoa));
		raiz->no = novo;
		raiz->aesq = NULL;
		raiz->adir = NULL;
		
	}else if(novo->idade <= raiz->no->idade){
		raiz->aesq = inserirPorIdade(raiz->aesq, novo);
		raiz = balanceamento(raiz);
		
	}else if(novo->idade > raiz->no->idade){
		raiz->adir = inserirPorIdade(raiz->adir, novo);
		raiz = balanceamento(raiz);
		
	}
	
	return raiz;
	
	
}

arv* inserirPorNome(arv* raiz, pessoa* novo){
//	lista* l;
	if(raiz ==NULL){
		raiz = (arv*) malloc(sizeof(arv));
		raiz->no = (pessoa*) malloc(sizeof(pessoa));
		raiz->no = novo;
		raiz->aesq = NULL;
		raiz->adir = NULL;
	}else{
	//	printf("nome1: %s nome2: %s e comparacao: %d\n",raiz->no->nome, novo->nome , strcmp(raiz->no->nome, novo->nome));
		if(strcmp(raiz->no->nome, novo->nome)>0){
		//	printf("ESQUERDA\n");
			raiz->aesq = inserirPorNome(raiz->aesq, novo);
			raiz = balanceamento(raiz);
			
		//	l = listaEmOrdem(raiz);
		//	imprimirLista(l);
				
		}else if(strcmp(raiz->no->nome, novo->nome)<=0){
		//	printf("DIREITA\n");
			raiz->adir = inserirPorNome(raiz->adir, novo);
			raiz = balanceamento(raiz);
			
		//	l = listaEmOrdem(raiz);
		//	imprimirLista(l);
		}
	//	printf("\n");
	
	} 
	
	return raiz;
}

arv* inserirPorAltura(arv* raiz, pessoa* novo){
	
	if(raiz ==NULL){
		raiz = (arv*) malloc(sizeof(arv));
		raiz->no = (pessoa*) malloc(sizeof(pessoa));
		raiz->no = novo;
		raiz->aesq = NULL;
		raiz->adir = NULL;		
	}else{
		if(novo->altura <= raiz->no->altura ){	
			raiz->aesq = inserirPorAltura(raiz->aesq, novo);
			raiz = balanceamento(raiz);
		}else if(novo->altura > raiz->no->altura ){		
			raiz->adir = inserirPorAltura(raiz->adir, novo);
			raiz = balanceamento(raiz);
		}		
	}
	
	return raiz;
}

pessoa* criarPessoaAleatoria(){	
	
		pessoa* est = (pessoa*) malloc(sizeof(pessoa));
		est->nome = nomeRandomico();
		est->idade = rand()%100;
		est->altura = 1.5 + (((float) (rand()%50))/100);	
	
	return est;
}

void emOrdem(arv* a){
	
	if(a != NULL){
		emOrdem(a->aesq);
		printf("Nome: %s		idade: %d		altura: %.2f\n", a->no->nome,a->no->idade,a->no->altura);
		emOrdem(a->adir);
	}else{
	
	}
}

void preOrdem(arv* a){
	if(a != NULL){
		
		printf("%d\n", a->no->idade);
		preOrdem(a->aesq);
		preOrdem(a->adir);
	}
}

lista* listaEmOrdem(arv* a){
	lista* l1 = NULL;
	lista* l2;
	lista* l3 = NULL;
	l2 = (lista*) malloc(sizeof(lista));	
	l2->next = NULL;
	lista* aux = NULL;

	if(a != NULL){
	
	
		l1 = listaEmOrdem(a->aesq);
	
		l2->item = a->no;
	
		l3 = listaEmOrdem(a->adir);
	
		
		if(l1 == NULL && l3 == NULL){
	
			return l2;
		}
		if(l1 != NULL && l3 == NULL){
			aux = l1;
			
			while(aux!= NULL){
				if(aux->next ==NULL) break;
			
				aux=aux->next;
			}
			aux->next = l2;
			
			return l1;
		}
		if(l3 != NULL && l1 == NULL){
			aux = l2;
			while(aux!=NULL){
				if(aux->next ==NULL) break;
				aux = aux->next;
			}
			aux->next = l3;
			
			return l2;
		}
		aux = l1;
		while(aux!=NULL){
			if(aux->next ==NULL) break;
			aux=aux->next;
		}
		aux->next = l2;
		while(aux!=NULL){
			if(aux->next ==NULL) break;
			aux=aux->next;
		}
		aux->next = l3;
		
		return l1;
	}

	return NULL;
	
}

void imprimirLista(lista* l){

	while(l != NULL){
		
		//printf(" %s ->", l->item->nome);
		printf("Nome: %s		idade: %d		altura: %.2f\n",  l->item->nome, l->item->idade, l->item->altura);
		
		
		l = l->next;
		
	}
	printf("\n");

}



lista* prioridadeIdadeNome(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(current->item->idade == next->item->idade){
			if(strcmp(current->item->nome,next->item->nome)>0){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(strcmp(next->item->nome,aux->nome)<0){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(current->item->idade != next->item->idade) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}

lista* prioridadeIdadeAltura(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(current->item->idade == next->item->idade){
			
			if(current->item->altura > next->item->altura){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(next->item->altura < aux->altura){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(current->item->idade != next->item->idade) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}

lista* prioridadeNomeIdade(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(strcmp(current->item->nome, next->item->nome)==0){
			
			if(current->item->idade > next->item->idade){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(next->item->idade < aux->idade){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(strcmp(current->item->nome, next->item->nome)!=0) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}

lista* prioridadeNomeAltura(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(strcmp(current->item->nome, next->item->nome)==0){
			
			if(current->item->altura > next->item->altura){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(next->item->altura < aux->altura){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(strcmp(current->item->nome, next->item->nome)!=0) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}

lista* prioridadeAlturaNome(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(current->item->altura == next->item->altura){
			
			if(strcmp(current->item->nome,next->item->nome)>0){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(strcmp(aux->nome, next->item->nome) > 0){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(current->item->altura != next->item->altura) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}

lista* prioridadeAlturaIdade(lista* l){
	lista* current = l;
	lista* next = l->next;
	lista* procura = l;
	int troca = FALSE;
	pessoa* aux;
	
	while(next != NULL){
		aux = NULL;
		procura = l; 
		while(current->item->altura == next->item->altura){
			
			if(current->item->idade > next->item->idade){
				if(aux == NULL){
					aux = next->item;
					troca = TRUE;
				}else if(aux->idade > next->item->idade){
					aux = next->item;
					troca = TRUE;
				}
			}
			if(current->item->altura != next->item->altura) break;
			if(next->next == NULL) break;
			next = next->next;
		}
		
		if(troca){
			while(procura->item != aux){
				procura = procura->next;
			}
			procura->item = current->item;
			current->item = aux;
		}
		
		troca = FALSE;
		if(current->next == NULL) break;
		current = current->next;
		if(next == NULL) break;
		next = current->next;
	}
	return l;
}


