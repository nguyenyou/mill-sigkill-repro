package generated

final case class Data7(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data7 = copy(name = name.toUpperCase)
  def scale(k: Double): Data7 = copy(value = value * k)
  def addTag(t: String): Data7 = copy(tags = t :: tags)
  def put(k: String, v: String): Data7 = copy(meta = meta.updated(k, v))
  def merge(other: Data7): Data7 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data7 {
  given Ordering[Data7] = Ordering.by(_.id)
  def empty: Data7 = Data7(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data7 =
    Data7(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data7] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
