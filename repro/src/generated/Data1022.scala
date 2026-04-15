package generated

final case class Data1022(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1022 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1022 = copy(value = value * k)
  def addTag(t: String): Data1022 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1022 = copy(meta = meta.updated(k, v))
  def merge(other: Data1022): Data1022 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1022 {
  given Ordering[Data1022] = Ordering.by(_.id)
  def empty: Data1022 = Data1022(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1022 =
    Data1022(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1022] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
