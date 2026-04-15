package generated

final case class Data545(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data545 = copy(name = name.toUpperCase)
  def scale(k: Double): Data545 = copy(value = value * k)
  def addTag(t: String): Data545 = copy(tags = t :: tags)
  def put(k: String, v: String): Data545 = copy(meta = meta.updated(k, v))
  def merge(other: Data545): Data545 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data545 {
  given Ordering[Data545] = Ordering.by(_.id)
  def empty: Data545 = Data545(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data545 =
    Data545(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data545] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
