package generated

final case class Data722(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data722 = copy(name = name.toUpperCase)
  def scale(k: Double): Data722 = copy(value = value * k)
  def addTag(t: String): Data722 = copy(tags = t :: tags)
  def put(k: String, v: String): Data722 = copy(meta = meta.updated(k, v))
  def merge(other: Data722): Data722 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data722 {
  given Ordering[Data722] = Ordering.by(_.id)
  def empty: Data722 = Data722(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data722 =
    Data722(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data722] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
