package generated

final case class Data437(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data437 = copy(name = name.toUpperCase)
  def scale(k: Double): Data437 = copy(value = value * k)
  def addTag(t: String): Data437 = copy(tags = t :: tags)
  def put(k: String, v: String): Data437 = copy(meta = meta.updated(k, v))
  def merge(other: Data437): Data437 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data437 {
  given Ordering[Data437] = Ordering.by(_.id)
  def empty: Data437 = Data437(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data437 =
    Data437(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data437] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
