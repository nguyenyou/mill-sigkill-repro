package generated

final case class Data928(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data928 = copy(name = name.toUpperCase)
  def scale(k: Double): Data928 = copy(value = value * k)
  def addTag(t: String): Data928 = copy(tags = t :: tags)
  def put(k: String, v: String): Data928 = copy(meta = meta.updated(k, v))
  def merge(other: Data928): Data928 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data928 {
  given Ordering[Data928] = Ordering.by(_.id)
  def empty: Data928 = Data928(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data928 =
    Data928(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data928] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
