package generated

final case class Data200(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data200 = copy(name = name.toUpperCase)
  def scale(k: Double): Data200 = copy(value = value * k)
  def addTag(t: String): Data200 = copy(tags = t :: tags)
  def put(k: String, v: String): Data200 = copy(meta = meta.updated(k, v))
  def merge(other: Data200): Data200 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data200 {
  given Ordering[Data200] = Ordering.by(_.id)
  def empty: Data200 = Data200(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data200 =
    Data200(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data200] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
