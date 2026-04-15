package generated

final case class Data1046(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1046 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1046 = copy(value = value * k)
  def addTag(t: String): Data1046 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1046 = copy(meta = meta.updated(k, v))
  def merge(other: Data1046): Data1046 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1046 {
  given Ordering[Data1046] = Ordering.by(_.id)
  def empty: Data1046 = Data1046(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1046 =
    Data1046(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1046] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
