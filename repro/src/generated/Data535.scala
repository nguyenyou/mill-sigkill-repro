package generated

final case class Data535(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data535 = copy(name = name.toUpperCase)
  def scale(k: Double): Data535 = copy(value = value * k)
  def addTag(t: String): Data535 = copy(tags = t :: tags)
  def put(k: String, v: String): Data535 = copy(meta = meta.updated(k, v))
  def merge(other: Data535): Data535 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data535 {
  given Ordering[Data535] = Ordering.by(_.id)
  def empty: Data535 = Data535(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data535 =
    Data535(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data535] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
