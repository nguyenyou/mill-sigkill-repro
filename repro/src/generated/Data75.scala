package generated

final case class Data75(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data75 = copy(name = name.toUpperCase)
  def scale(k: Double): Data75 = copy(value = value * k)
  def addTag(t: String): Data75 = copy(tags = t :: tags)
  def put(k: String, v: String): Data75 = copy(meta = meta.updated(k, v))
  def merge(other: Data75): Data75 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data75 {
  given Ordering[Data75] = Ordering.by(_.id)
  def empty: Data75 = Data75(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data75 =
    Data75(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data75] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
