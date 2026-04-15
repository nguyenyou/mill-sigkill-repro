package generated

final case class Data1086(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1086 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1086 = copy(value = value * k)
  def addTag(t: String): Data1086 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1086 = copy(meta = meta.updated(k, v))
  def merge(other: Data1086): Data1086 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1086 {
  given Ordering[Data1086] = Ordering.by(_.id)
  def empty: Data1086 = Data1086(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1086 =
    Data1086(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1086] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
