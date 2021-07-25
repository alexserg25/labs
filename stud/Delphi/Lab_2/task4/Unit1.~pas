unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    eAx: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    eBx: TEdit;
    eCx: TEdit;
    Button1: TButton;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    eAy: TEdit;
    eBy: TEdit;
    eCy: TEdit;
    PTriangle: TLabel;
    btnClose: TButton;
    procedure Button1Click(Sender: TObject);
    procedure btnCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var
  // Объявление переменных для хранени введенных данных
  Ax, Ay, Bx, By, Cx, Cy: Integer;
  // Объявление переменной для результата рассчета
  AB, BC, CA, P: Double;
begin
  // Инициализация переменных введенными данными
  Ax := StrToInt(eAx.Text);
  Ay := StrToInt(eAy.Text);
  Bx := StrToInt(eBx.Text);
  By := StrToInt(eBy.Text);
  Cx := StrToInt(eCx.Text);
  Cy := StrToInt(eCy.Text);


  // Получение длин сторон треугольника
  AB := sqrt(sqr(Bx - Ax) + sqr(By - Ay));
  BC := sqrt(sqr(Cx - Bx) + sqr(Cy - By));
  CA := sqrt(sqr(Ax - Cx) + sqr(Ay - Cy));

  // Получение периметра.
  P := abs(AB) + abs(BC) + abs(CA);

  // Вывод на экран полученного результата
  PTriangle.Caption := 'Периметр треугольника = ' + FloatToStr(P);



end;

procedure TForm1.btnCloseClick(Sender: TObject);
begin
  Close;
end;

end.
