package generated

final case class Data349(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data349 = copy(name = name.toUpperCase)
  def scale(k: Double): Data349 = copy(value = value * k)
  def addTag(t: String): Data349 = copy(tags = t :: tags)
  def put(k: String, v: String): Data349 = copy(meta = meta.updated(k, v))
  def merge(other: Data349): Data349 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data349 {
  given Ordering[Data349] = Ordering.by(_.id)
  def empty: Data349 = Data349(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data349 =
    Data349(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data349] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
