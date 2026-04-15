package generated

final case class Data306(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data306 = copy(name = name.toUpperCase)
  def scale(k: Double): Data306 = copy(value = value * k)
  def addTag(t: String): Data306 = copy(tags = t :: tags)
  def put(k: String, v: String): Data306 = copy(meta = meta.updated(k, v))
  def merge(other: Data306): Data306 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data306 {
  given Ordering[Data306] = Ordering.by(_.id)
  def empty: Data306 = Data306(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data306 =
    Data306(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data306] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
