package generated

final case class Data1074(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1074 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1074 = copy(value = value * k)
  def addTag(t: String): Data1074 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1074 = copy(meta = meta.updated(k, v))
  def merge(other: Data1074): Data1074 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1074 {
  given Ordering[Data1074] = Ordering.by(_.id)
  def empty: Data1074 = Data1074(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1074 =
    Data1074(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1074] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
