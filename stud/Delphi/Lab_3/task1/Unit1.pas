unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    eFIO: TEdit;
    eNum: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    GroupBox1: TGroupBox;
    rbStudent: TRadioButton;
    rbProfessor: TRadioButton;
    btnAddList: TButton;
    btnViewList: TButton;
    procedure btnAddListClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;
       
   // ������� �����
  TPerson=class
    protected
       fname:string; // ���
       // ���������� ������������ �������
       constructor  Create(name:string);
       // ����� ��������� �����.
       function GetName: String;
       // ����������� ����� info, ����� ���������������� ���������
       function info: string; virtual;
    public
      // ��������� �������� Name, ��� ������� � fname
      Property Name: String
      read GetName;
  end;
  // ����������� �� �������� TPerson
  TStud=class(TPerson)
      fgr:integer; // ����� ������
      // ���������� ������������ �������
      constructor Create(name:string;gr:integer);
      // ��������������� ������ ������ info
      function info: string; override;
  end;
  // ����������� �� �������� TPerson
  TProf=class(TPerson)
      fdep:string; // �������� �������
      constructor  Create(name:string;dep:string);
      // ��������������� ������ ������ info
      function info: string; override;
  end;


var
  Form1: TForm1;




implementation

{$R *.dfm}

const
  // ������ �������
  SZL = 10;
var
  // ������ �����
  list:array[1..SZL] of TPerson;
  // ������� ����� ����� � ������
  countPers: Integer; 

  // ����������� ������� TPerson
  constructor TPerson.Create(name: String);
  begin
    fname := name;
  end;

  // ����������� ������� TStud
  constructor TStud.Create(name:string;gr:integer);
  begin
    // ��������� � ������������ ������������� ������.
    inherited Create(name);
    fgr := gr;
  end;

  // ����������� ������� TProf
  constructor TProf.Create(name:string;dep:string);
  begin
    // ��������� � ������������ ������������� ������.
    inherited Create(name);
    fdep := dep;
  end;

  // �������� ������������ ������
  function  TPerson.info:string;
  begin
      result:='';
  end;

  //����� ��������� �������� �������� Name
  Function TPerson.GetName;
  begin
    Result := FName;
  end;


  function  TStud.info:string;
  begin
       result := fname + ' �p.' + IntTostr(fgr);
  end;


  function  TProf.info:string;
  begin
        result := fname + '���.' + fdep;
  end;


procedure TForm1.btnAddListClick(Sender: TObject);
begin
  ShowMessage('Test');
end;

end.
