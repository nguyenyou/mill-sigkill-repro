package generated

final case class Data1057(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1057 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1057 = copy(value = value * k)
  def addTag(t: String): Data1057 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1057 = copy(meta = meta.updated(k, v))
  def merge(other: Data1057): Data1057 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1057 {
  given Ordering[Data1057] = Ordering.by(_.id)
  def empty: Data1057 = Data1057(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1057 =
    Data1057(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1057] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
