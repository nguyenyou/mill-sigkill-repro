package generated

final case class Data149(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data149 = copy(name = name.toUpperCase)
  def scale(k: Double): Data149 = copy(value = value * k)
  def addTag(t: String): Data149 = copy(tags = t :: tags)
  def put(k: String, v: String): Data149 = copy(meta = meta.updated(k, v))
  def merge(other: Data149): Data149 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data149 {
  given Ordering[Data149] = Ordering.by(_.id)
  def empty: Data149 = Data149(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data149 =
    Data149(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data149] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
