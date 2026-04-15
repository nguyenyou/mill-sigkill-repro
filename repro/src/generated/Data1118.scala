package generated

final case class Data1118(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1118 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1118 = copy(value = value * k)
  def addTag(t: String): Data1118 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1118 = copy(meta = meta.updated(k, v))
  def merge(other: Data1118): Data1118 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1118 {
  given Ordering[Data1118] = Ordering.by(_.id)
  def empty: Data1118 = Data1118(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1118 =
    Data1118(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1118] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
