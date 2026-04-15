package generated

final case class Data1029(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1029 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1029 = copy(value = value * k)
  def addTag(t: String): Data1029 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1029 = copy(meta = meta.updated(k, v))
  def merge(other: Data1029): Data1029 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1029 {
  given Ordering[Data1029] = Ordering.by(_.id)
  def empty: Data1029 = Data1029(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1029 =
    Data1029(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1029] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
