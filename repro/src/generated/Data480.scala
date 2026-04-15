package generated

final case class Data480(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data480 = copy(name = name.toUpperCase)
  def scale(k: Double): Data480 = copy(value = value * k)
  def addTag(t: String): Data480 = copy(tags = t :: tags)
  def put(k: String, v: String): Data480 = copy(meta = meta.updated(k, v))
  def merge(other: Data480): Data480 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data480 {
  given Ordering[Data480] = Ordering.by(_.id)
  def empty: Data480 = Data480(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data480 =
    Data480(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data480] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
