package generated

final case class Data30(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data30 = copy(name = name.toUpperCase)
  def scale(k: Double): Data30 = copy(value = value * k)
  def addTag(t: String): Data30 = copy(tags = t :: tags)
  def put(k: String, v: String): Data30 = copy(meta = meta.updated(k, v))
  def merge(other: Data30): Data30 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data30 {
  given Ordering[Data30] = Ordering.by(_.id)
  def empty: Data30 = Data30(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data30 =
    Data30(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data30] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
